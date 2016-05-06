/**
 * 
 */
'use strict';
 
MiscModule.factory('pushMessageService', function($http, $q){
 
    return {
    	pushMessage: function(payload) {
                    return $http.post('http://192.168.2.177:9090/oa/misc/message',payload)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while pushMessage');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
    };
});