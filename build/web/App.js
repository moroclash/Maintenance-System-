//Define an angular module for our app
var myApp = angular.module('myApp', []);

//Define Routing for app
//Uri /AddNewOrder -> template AddOrder.html and Controller AddOrderController
//Uri /ShowOrders -> template ShowOrders.html and Controller AddOrderController
myApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
      when('/item1', {
	templateUrl: 'Search2.html'
      }).
      when('/item2', {
	templateUrl: 'item2.html'
      })
}]);

