<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Push Message To JPush</title>
<link rel="stylesheet" href="<c:url value='/static/css/app.css'/>">
<link rel="stylesheet" href="<c:url value='/3rd/bootstrap/dist/css/bootstrap.min.css'/>">
</head>
<body ng-app="miscModule" class="ng-cloak">
	<div class="generic-container" ng-controller="PushMessageController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Push Message Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Audience</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.payload.audience" id="audience" class="username form-control input-sm" placeholder="Enter The Audience To Receive Message" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                         
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="address">MsgContent</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.payload.msgContent" id="msgContent" required class="form-control input-sm" 
                                  	placeholder="Enter your Message Content:{&quot;deviceId&quot;:&quot;N800_0042&quot;,&quot;time&quot;:&quot;160428161532&quot;,&quot;event&quot;:1}"/>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="address">AppName</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.payload.appId" ng-options="m.name for m in ctrl.app" class="form-control" readonly required>
								    <option value="">-- 请选择 --</option>
								</select>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="address">MsgType</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.payload.msgType" ng-options="m.name for m in ctrl.msg" class="form-control" readonly required>
								    <option value="">-- 请选择 --</option>
								</select>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="Push" class="btn btn-primary btn-sm" ng-enabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
      </div>
      
      <div class="generic-container" ng-controller="DeviceController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Device Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="deviceForm" class="form-horizontal">
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Device Id</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.device.id" id="id" class="form-control input-sm" placeholder="Enter The DeviceId" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="deviceForm.$dirty">
                                      <span ng-show="deviceForm.id.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="Add" class="btn btn-primary btn-sm" ng-enabled="deviceForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="deviceForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
      </div>
       
      <script src="<c:url value='/3rd/angular/angular.js'/>"></script>
      <script src="<c:url value='/static/js/misc_module.js'/>"></script>
      <script src="<c:url value='/static/js/service/push_message_service.js'/>"></script>
      <script src="<c:url value='/static/js/controller/push_message_controller.js'/>"></script>
      <script src="<c:url value='/static/js/service/device_service.js'/>"></script>
      <script src="<c:url value='/static/js/controller/device_controller.js'/>"></script>
</body>
</html>