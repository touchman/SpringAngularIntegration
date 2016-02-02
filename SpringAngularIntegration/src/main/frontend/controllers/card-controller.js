(function() {
    'use strict';

    angular.module('card.Controller', [])
        .controller('cardController', ['$http', '$routeParams', '$window',  function ($http, $routeParams, $window) {
            var vm = this;

            vm.car = "";

            var cardId = $routeParams.cardId

            getAllCards(cardId);


            function getCard(id){
                $http.get('http://localhost:8080/card/' + id + '/').then(function(data){
                    vm.card = data.data;
                })
            }

            vm.remove = function(id){
                $http.delete('http://localhost:8080/card/' + id).then(function(){
                    console.log("removing");
                    getAllCards(cardId);
                })
            };

            vm.add = function(card){
                card.cardId = $routeParams.cardId;
                console.log(card);
                $http.post('http://localhost:8080/card/', card).then(function(){
                    console.log("adding");

                    getAllCards(cardId);
                })
            };

            vm.update = function(card){
                $http.post('http://localhost:8080/card/' + card.id, card).then(function(){
                    console.log("updating");
                    console.log(card);
                    getAllCards(cardId);
                })
            };

            vm.select = function(card){
                vm.car = card;
                vm.car.year = new Date(card.year);
                console.log(vm.car);
            };

            function getAllCards(cardId){
                $http.get('http://localhost:8080/card/' + cardId + '/').then(function(data){
                  vm.cards = data.data;
                })
            }

            vm.getOrder = function (order_id) {
                $window.location.href = '#/order/' + order_id + '/';
            }
        }]);
})();