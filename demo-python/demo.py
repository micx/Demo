#encoding:utf-8
from Utils import *
#验卷测试
verifyTest =  DpInterface.verifyReceipt(Config.verifyxml)
print "verifyResult: "+verifyTest

#查询测试
queryTest =  DpInterface.queryReceipt(Config.queryxml)
print "queryResult: "+queryTest


#发卷测试
#sendTest =  DpInterface.sendReceipt(Config.sendxml)
#print "sendResult: "+sendTest

#退卷测试
#refundTest =  DpInterface.refundReceipt(Config.refundxml)
#print "refundResult: "+refundTest


