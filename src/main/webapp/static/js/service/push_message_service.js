/**
 * 
 */
'use strict';
 
MessageModule.factory('pushMessageService', ['$http', '$q', function($http, $q){
 
    return {
    	pushMessage: function(payload) {
                    return $http.post('http://localhost:8080/oa/misc/message',payload)
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
 
}]);