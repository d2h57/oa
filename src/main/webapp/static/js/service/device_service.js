/**
 * 
 */
'use strict';
 
MiscModule.factory('deviceService', function($http, $q){
 
    return {
    	add: function(device) {
                    return $http.post('http://localhost:8080/oa/misc/device',device)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        return $q.reject(errResponse);
                                    }
                            );
            }
    };
});