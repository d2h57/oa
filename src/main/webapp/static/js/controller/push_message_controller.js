/**
 * 
 */

'use strict';
 
MessageModule.controller('PushMessageController', ['$scope', 'pushMessageService', function($scope, pushMessageService) {
          var self = this;
          self.payload={audience:'',msgContent:'',appId:0,msgType:0};
          self.model = [{id:0,name:'钮眼'},{id:1,name:'钮家'}];
            
          self.pushMessage = function(payload){
        	  pushMessageService.pushMessage(payload)
                      .then(
                    		  function(response){
                    			  console.log(response.data);
                    		  },
                              function(errResponse){
                                   console.error('Error while creating User.');
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
      }]);