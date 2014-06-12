#encoding:utf-8

user_agent = 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'
headers = { 'User-Agent' : user_agent }

'''
	查询、验证   HOST
	环境  host
	测试环境    180.166.152.82:5680
	生产环境    180.153.132.83
	点评提供服务host
'''
dpHost= "180.166.152.82:5680"	#测试环境
#dpHost= "180.153.132.83";		#生产环境

#第三方填入服务host
thirdPartyHost= "http://xxx.xxx.xxx"

'''
	密钥
	环境  md5key
	测试环境    d61b2a012014b9b5648579d406b190b4
	生产环境    具体对接时提供
'''
md5Key = "d61b2a012014b9b5648579d406b190b4"

'''
	xml报文
	verify.xml
	query.xml
	sendreceipt.xml
	refundreceipt.xml
'''
verifyFile = open("Utils/xml/verify.xml","r")
verifyxml = verifyFile.read()
verifyFile.close();

queryFile = open("Utils/xml/query.xml","r")
queryxml = queryFile.read()
queryFile.close();

sendFile = open("Utils/xml/sendreceipt.xml","r")
sendxml = sendFile.read()
sendFile.close();

refundFile = open("Utils/xml/refundreceipt.xml","r")
refundxml = refundFile.read()
refundFile.close();

