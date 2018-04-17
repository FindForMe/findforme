var app = angular.module('pageApp',[]);

app.controller('postCtrl', function($scope, $http){
	console.log('postCtrl');
	$scope.test = 'hello angular';
	//var jsonUrl = window.contextRoot+'/json/data/all/post';
	//$scope.obj = array;
	$http.get(jsonUrl)
	.then(function (response){
		console.log('angurlar ok response');
		$scope.obj = response.data;
	}, function(response){
		console.log('angurlar error response');
	});
	
});
var jsonUrl
if(window.categoryId == ''){
	jsonUrl = window.contextRoot+'/json/data/all/post';
}else{
	jsonUrl = window.contextRoot+'/json/data/category/'+window.categoryId+'/post';
}


var array = [{"id":1,"title":"title","description":"this is description","userId":0,"categoryId":1,"code":"","active":true,"expireDate":"33","view":1,"apply":0,"file":null},
	{"id":2,"title":"title2","description":"this is description1","userId":0,"categoryId":1,"code":"","active":true,"expireDate":"12","view":3,"apply":0,"file":null},
	{"id":3,"title":"title3","description":"this is description2","userId":2,"categoryId":2,"code":"","active":true,"expireDate":"01","view":5,"apply":0,"file":null},
	{"id":4,"title":"title4","description":"this is description3","userId":2,"categoryId":2,"code":"","active":true,"expireDate":"58","view":0,"apply":0,"file":null}];