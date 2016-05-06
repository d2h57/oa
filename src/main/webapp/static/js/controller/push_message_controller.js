/**
 * 
 */

'use strict';
 
MiscModule.controller('PushMessageController', function($scope, pushMessageService,$window) {
          var self = this;
          self.payload = {audience:'',msgContent:'',appId:'',msgType:''};
          self.app = [{id:0,name:'钮眼'},{id:1,name:'钮家'}];
          self.msg = [{id:0,name:'Notification'},{id:1,name:'Message'}];
            
          self.pushMessage = function(payload){
        	  var info = {audience:payload.audience,msgContent:payload.msgContent,appId:payload.appId.id,msgType:payload.msgType.id};
        	  pushMessageService.pushMessage(info)
                      .then(
                    		  function(response){
                    			  console.log(JSON.stringify(response));
                    			  $window.alert("result:"+response.result);
                    		  },
                              function(errResponse){
                    			  $window.alert("result:-1");
                                   console.error('Error while pushing message.');
                              } 
                  );
          };
 
          self.submit = function() {
        	  console.log('Push New Message', self.payload);    
        	  self.pushMessage(self.payload);
          };
           
          self.reset = function(){
              self.payload={audience:'',msgContent:''};
              $scope.myForm.$setPristine(); //reset Form
          };
      });