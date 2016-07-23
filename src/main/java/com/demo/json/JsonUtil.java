package com.demo.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

public final class JsonUtil {

	private final static Logger logger = Logger.getLogger(JsonUtil.class);
	//volatile 不同线程在读取该对象时，会从内存中同步，一种弱同步锁
	//ObjectMapper在方法调用中实例化开销约是全局变量的47倍
	private static volatile ObjectMapper mapper = new ObjectMapper();
	
	static {
		
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}
	
	/**
	 * 可转换泛型类
	 * ElemeResult<ElemeCartResponse> obj = mapper.readValue(resp, new TypeReference<ElemeResult<ElemeCartResponse>>() {});
	 * List<BookingTime> list = JsonUtil.parseObject(bookingTimeJson, new TypeReference<List<BookingTime>>() {});
	 * @param content
	 * @param valueTypeRef
	 * @return
	 * @throws IOException
	 */
	public static <T> T parseObject(String content, TypeReference<T> valueTypeRef)throws IOException {
		return mapper.readValue(content,valueTypeRef);
	}
	
	/**
	 * 将json字符串转成指定类实例
	 * @param content
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String content, Class<T> clazz) throws IOException {
		return mapper.readValue(content, clazz);
	}

	
	/**
	 * 将对象转换成json字符串
	 * @param vo，
	 * @return 
	 */
	public static String parseJson(Object vo) {
		try {
			return mapper.writeValueAsString(vo);
		}  catch (Exception e) {
			logger.error(String.format("fail to parseJson [%s]", vo.toString()), e);
		}
		return null;
	}
}
