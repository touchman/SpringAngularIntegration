angular.module('service', ['client.Controller', 'order.Controller', 'card.Controller', 'ngRoute'])
    .config(['$routeProvider','$httpProvider', function ($routeProvider, $httpProvider) {
    $routeProvider
        .when('/client', {
            templateUrl: 'template/client.html',
            controller: 'clientController'
        })
        .when('/card', {
            templateUrl: 'template/card.html',
            controller: 'cardController'
        })
        .when('/order', {
            templateUrl: 'template/order.html',
            controller: 'orderController'
        })
        .when('/card/:cardId',{
            templateUrl: 'template/card.html',
            controller: 'cardController'
        })
        .when('/order/:orderId', {
            templateUrl: 'template/order.html',
            controller: 'orderController'
        })
        .otherwise({
            redirectTo: '/client'
        });
}]);