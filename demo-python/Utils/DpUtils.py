#encoding:utf-8
import md5

def buildMD5Sign(xml, md5Key):
	content = "xml="+xml+md5Key
	encryText = MD5Encrypt(content,"utf-8")
	return encryText


def MD5Encrypt(plainText, ecode):
	return md5.new(plainText.encode(ecode)).hexdigest()


