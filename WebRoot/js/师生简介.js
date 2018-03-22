;(function($) {
	var n = 0;
	window.onload = function(){
		var datas = data;  //data.js里的数据，对象数组
		var template = document.querySelector('.choosePhotoBox').innerHTML;
		addPeople(datas,template);
		rsort(n);
		mouseEvent();
	}
	
	function addPeople(data,template){
		
		var html = [];
		for(s in data){
			var _html = template.replace('{{index}}',s)
								.replace('{{img}}',data[s].img)
								.replace('{{name}}',data[s].name)
								.replace("{{content}}",data[s].content);
			html.push(_html);
		}
		document.querySelector('.choosePhotoBox').innerHTML = html.join('');
		
		var photos = document.querySelectorAll(".aPhoto");
		
		var l = photos.length;
		for(var i=0; i<l; i++) {
			
			(function(i) {
				photos[i].onclick = function(){
					if(i === n) backShow(data);
				}
			})(i);
		}
		
		for(var i=0; i<photos.length; i++){
			photos[i].addEventListener('click',indexChange.bind(null,i),false);
		}
		
		n=0;
	}
	
	function rsort(){
		var maxR = 350, minR = 150;
		var _photo = document.querySelectorAll('.photo');
		var l = _photo.length;
		var photos = [];
		var degrees = 2 * Math.PI / l;
		
		for(var s = n; s < l+n; s++){		//把类数组转化成数组
			var t = s;
			if(t>=l) t=s-l;
//				console.log(t);
			_photo[t].className = 'photo';
			photos.push( _photo[t] );
		}
		
//			console.log(_photo)
		_photo[n].className += ' center';
		_photo[n].style['-webkit-transform'] = 'translate(0px,0px)';
		_photo[n].style['z-index'] = 99;	
			
		photos.splice(0,1);
		l = l - 1; 
		
//			console.log(photos)
		for(var s = 0; s < l ; s++){ 	// 把数组渲染出来
			var disX = Math.sin(degrees * (s +1)) * maxR, disY = Math.cos(degrees * (s +1)) * minR;
//				console.log(disX + "   "+ disY);
			photos[s].style['-webkit-transform'] = 'translate(' + disX + 'px, ' + disY + 'px)';
			if(s<l/2){
				photos[s].style['z-index'] = photos[l-s-1].style['z-index'] = 50-s;
			}
		}
	}
	
	function mouseEvent(){
		var _left = document.querySelector('.button_left');
		var _right = document.querySelector('.button_right');
		var photos = document.querySelectorAll('.photo');
		
		_left.addEventListener('click', indexChange.bind(null,'-'), false);
		_right.addEventListener('click', indexChange.bind(null,'+'), false);
		
	}
	function indexChange(operator){
		var l = document.querySelectorAll('.photo').length;
		if(operator == '-'){
			if(--n < 0){
				n = l-1;
			}
		}else 
		if(operator == '+'){
			if(++n > l-1){
				n = 0;
			}
		}else{
			n = operator;
			rsort(n);
			return ;
		}
		
		rsort();
	}	
	
	function backShow(data) {
		var back = document.querySelector(".back");
		var backContent = back.querySelector(".content");
		backContent.innerHTML = data[n].content;
		back.style["display"] = "block";
		back.style["transform"] = "rotateY(0deg)";
		$(".mask")[0].style['display'] = "block";
		back.querySelector(".top").innerHTML = data[n].name;
	}
	
	$(document).ready(function() {
		var ul = $(".leftNav ul"),
			lis = ul.find("li");
		var RegExp1 = /教师/,
			RegExp2 = /硕士/,
			RegExp3 = /本科生/,
			_datas = [];
		var template = document.querySelector('.choosePhotoBox').innerHTML;
		for(var i=0; i<lis.length-1; i++) {
			(function(i) {
				lis.eq(i).click(function() {
					switch (i) {
						case 0: 
							closeShow();
							addPeople(data, template);
							rsort();
							break;
						case 1: 
							for(var j=0; j<data.length; j++)
								if(RegExp1.test(data[j].title)) {
									_datas.push(data[j]);
								}
							closeShow();
							addPeople(_datas, template);
							rsort();
							_datas = [];
							break;
						case 2:
							for(var j=0; j<data.length; j++)
								if(RegExp2.test(data[j].title)) {
									_datas.push(data[j]);
								}
							closeShow();
							addPeople(_datas, template);
							rsort();
							_datas = [];
							break;	
						case 3:
							for(var j=0; j<data.length; j++)
								if(RegExp3.test(data[j].title)) {
									_datas.push(data[j]);
								}
							closeShow();
							addPeople(_datas, template);
							rsort();
							_datas = [];
							break;
					}
				})
			})(i)
		}
		
		var back = document.querySelector(".back");
		var x = back.querySelector(".x");
		
		x.addEventListener("click", function() {
			closeShow();
		}, false)
		
		function closeShow() {
			back.style["transform"] = "rotateY(90deg)"
			$(".mask")[0].style['display'] = "none";
		}
	})
})(jQuery);
