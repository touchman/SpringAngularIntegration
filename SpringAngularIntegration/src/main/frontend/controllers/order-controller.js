(function() {
    'use strict';

    angular.module('order.Controller', [])
        .controller('orderController', ['$http', '$routeParams',  function ($http, $routeParams) {
            var vm = this;

            vm.ord = "";

            var orderId = $routeParams.orderId;

            console.log(orderId);

            getAllOrders(orderId);

            function getOrder(id){
                $http.get('http://localhost:8080/order/' + id + '/').then(function(data){
                    vm.order = data.data;
                })
            }

            vm.remove = function(id){
                $http.delete('http://localhost:8080/order/' + id).then(function(){
                    console.log("removing");
                    getAllOrders(orderId);
                })
            };

            vm.add = function(order){
                order.orderId = orderId;
                $http.post('http://localhost:8080/order/', order).then(function(){
                    console.log("adding");
                    console.log(order);
                    getAllOrders(orderId);
                })
            };

            vm.update = function(order){
                $http.post('http://localhost:8080/order/' + order.id, order).then(function(){
                    console.log("updating");
                    console.log(order);
                    getAllOrders(orderId);
                })
            };

            vm.select = function(order){
                vm.ord = order;
                console.log(vm.ord);
            };

            function getAllOrders(orderId){
                $http.get('http://localhost:8080/order/' + orderId + '/').then(function(data){
                    vm.orders = data.data;
                })
            }

        }]);
})();