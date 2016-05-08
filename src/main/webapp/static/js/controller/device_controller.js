/**
 * 
 */

'use strict';
 
MiscModule.controller('DeviceController', function($scope, deviceService,$window) {
          var self = this;
          self.device = {id:'',type:1};
            
          self.add = function(device){
        	  deviceService.add(device)
                      .then(
                    		  function(response){
                    			  console.log(JSON.stringify(response));
                    			  $window.alert("result:"+response.result);
                    		  },
                              function(errResponse){
                    			  $window.alert("result:-1");
                                   console.error('Error while adding device.');
                              } 
                  );
          };
 
          self.submit = function() {
        	  console.log('Add New Device', self.device);    
        	  self.add(self.device);
          };
           
          self.reset = function(){
              self.device={id:'',type:1};
              $scope.deviceForm.$setPristine(); //reset Form
          };
      });