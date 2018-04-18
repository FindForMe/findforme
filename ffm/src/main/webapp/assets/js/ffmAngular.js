var app = angular.module('ffmApp',[]);
//$scope.$$prevSibling
var headerId = 'test';
app.service('headerService',function(){
	console.log('headerService');
	var id;
	var home = false;
	return {
		setId:function(value){
			id = value;
		},
		getId: function(){
			return id;
		},
		setHome:function(value){
			home = value;
		},
		getHome: function(){
			return home;
		}
	}
});

app.run(function($rootScope) {
    $rootScope.headerId = 'blank';
	$rootScope.homePage = false;

});

app.controller('headerCtrl', function($scope,headerService ){
	console.log('headerCtrl');
	//$scope.headerId = headerService.getId();
	//$scope.homePage = headerService.getHome();
});

app.controller('homeCtrl', function($scope, headerService, $rootScope){
	console.log('homeCtrl');
	$rootScope.homePage = true;
	$rootScope.headerId = 'home';
	//headerService.setId('home');
	//headerService.setHome(true);
	//$scope.$$prevSibling.navClass = 'nav-transparent';
	//$scope.$$prevSibling.homePage = true;
});
app.controller('postCtrl', function($scope, $http , headerService, $rootScope){
	console.log('postCtrl');
	$rootScope.headerId = 'post';
	$rootScope.homePage = false;
	//headerService.setId('post');
	//$scope.test = 'hello angular';
	//$scope.$$prevSibling.homePage = false;
	//var jsonUrl = window.contextRoot+'/json/data/all/post';
	//$scope.obj = array;
	$http.get(jsonUrl)
	.then(function (response){
		console.log('angurlar ok response');
		$scope.obj = response.data;
	}, function(response){
		console.log('angurlar error response');
	});
	$http.get(window.contextRoot+'/json/data/all/category')
	.then(function(response){
		console.log('angular ok category');
		$scope.jCategory = response.data;
	},function(response){
		console.log('angular error response');
		$scope.jCategory = response.data;
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