#encoding:utf-8
import urllib
import urllib2
import httplib
import DpUtils
import Config



def httprequest(url, xml):
	sign = DpUtils.buildMD5Sign(xml,Config.md5Key)
	values = {'xml' : xml,
	          'sign' : sign
	          }
	data = "xml="+xml+"&"+"sign="+sign
	req = urllib2.Request(url, data, Config.headers)
	response = urllib2.urlopen(req)
	the_page = response.read()
	return the_page

	
'''
	说明：序列号验证接口。三方系统在用户使用券后，实时向大众点评发起请求，点评按规定格式返回。
    大众点评地址：http://host/thirdparty/verifyreceipt?xml=xxx&sign=xxx
    参数说明：sign为验签参数，xml为提交报文。
'''
def verifyReceipt(xml):
	url = "http://"+Config.dpHost+"/thirdparty/verifyreceipt"
	return httprequest(url, xml)



'''
    说明：序列号查询接口。三方系统可向大众点评发起查询序列号状态请求，点评按规定格式返回。查询接口不需要流水号。
    大众点评地址：http://host/thirdparty/queryreceipt?xml=xxx&sign=xxx
    参数说明：sign为验签参数，xml为提交报文。
'''
def queryReceipt(xml):
	url = "http://"+Config.dpHost+"/thirdparty/queryreceipt"
	return httprequest(url, xml)


'''
    说明：序列号发送接口。大众点评发起请求，对接方按规定格式返回。
    请求类型：GET
    合作方地址：http://host/sendreceipt?xml=xxx&sign=xxx
    参数说明：sign为验签参数，xml为提交报文。
'''
def sendReceipt(xml):
	url = "http://"+Config.thirdPartyHost+"/sendreceipt"
	return httprequest(url, xml)
	
'''
	接口说明：序列号退券接口，由点评通知合作方将券置为已退券状态，对接方按规定格式返回。
    请求类型：GET
    合作方地址：http://host/refundreceipt?xml=xxx&sign=xxx
    参数说明：sign为验签参数，xml为提交报文。
'''
def refundReceipt(xml):
	url = "http://"+Config.thirdPartyHost+"/refundreceipt"
	return httprequest(url, xml)
