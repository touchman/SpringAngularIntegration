(function() {
    'use strict';

    angular.module('client.Controller', [])
        .controller('clientController', ['$http', '$window', '$filter',  function ($http, $window, $filter) {
            var vm = this;

            vm.cl = "";

            getAllClients();

            //putM();
            function getAllClients(){
                $http.get('http://localhost:8080/client/').then(function(data){
                    vm.clients = data.data;
                    console.log(data.data)
                })
            }

            vm.remove = function(id){
                $http.delete('http://localhost:8080/client/' + id).then(function(){
                    console.log("removing");
                    getAllClients();
                })
            };

            vm.add = function(client){
                $http.post('http://localhost:8080/client/', client).then(function(){
                    console.log("adding");
                    console.log(client);
                    getAllClients();
                })
            };

            vm.update = function(client){
                $http.post('http://localhost:8080/client/' + client.id, client).then(function(){
                    console.log("updating");
                    console.log(client);
                    getAllClients();
                })
            };

            vm.select = function(client){
                vm.cl = client;
                vm.cl.date = new Date(client.date);
                console.log(vm.cl);
            };

            vm.getCard = function (card_id) {
                $window.location.href = '#/card/' + card_id + '/';
            }
        }]);
})();