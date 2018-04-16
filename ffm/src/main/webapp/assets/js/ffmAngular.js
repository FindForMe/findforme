var app = angular.module('pageApp',[]);

app.controller('postCtrl', function($scope){
	console.log('postCtrl');
	$scope.test = 'hello angular';
	var jsonUrl = window.contextRoot+'/json/data/all/post';
	
});