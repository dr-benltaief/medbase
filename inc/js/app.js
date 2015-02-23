// Notre application AngularJS

(function(){
	var app = angular.module('medbase', ['ngRoute','ngSanitize','ngAnimate','ui.bootstrap']);
	app.config(function($routeProvider, $locationProvider, $compileProvider) {
		$routeProvider
			.when('/search/:page?', {templateUrl: 'tpls/search.html', controller: 'searchCtrl'})
			.when('/file/:id', {templateUrl: 'tpls/file.html', controller: 'fileCtrl'})
			.otherwise({redirectTo: '/search'});
		$compileProvider.aHrefSanitizationWhitelist(/^\s*(qrc|file):/);
		$compileProvider.imgSrcSanitizationWhitelist(/^\s*(qrc|file):/);
	});
	app.run(function($rootScope) {
		// Initialisation de l'objet global de recherche.
		$rootScope.search = function(method, terms) {
			if (typeof Qt === 'object' && Qt !== null) {
				return Qt.search(method, terms);
			} else if (typeof Android === 'object' && Android !== null) {
				return Android.search(method, terms);
			} else {
				return "Sans interface.";
			}
		};
		$rootScope.tabN = 1;
		$rootScope.terms = {
			specialite: '',
			dci: '',
			laboratoire: ''
		};
	});
	app.controller('searchCtrl', function($scope, $rootScope) {
		$scope.page = "search";
		$scope.tabF = function(tabN) {
			$rootScope.tabN = tabN;
			switch (tabN) {
				case 1:
					$scope.tab1 = true;
					$scope.tab2 = false;
					break;
				case 2:
					$scope.tab1 = false;
					$scope.tab2 = true;
					break;
			}
		};
		$scope.tabF($rootScope.tabN);
	});
	app.controller('fileCtrl', function($scope) {
		$scope.page = "file";
		$scope.$back = function() {
			window.history.back();
		};
	});
})();