var app5 = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue1.js!',
    productList: []
  },
  mounted:function(){
		// 根据官方文档添加$nextTick钩子，以保证该vm已被实例加载
		this.$nextTick(function(){
			// 调用getJson方法(已经在methods内定义)
			this.selectGifts();
		})
	},
  methods: {
	  selectGifts : function (){
		  var _this = this;
		  this.$http.get("/nzb/selectGifts",{"id":123}).then(function(res){
			  console.info(res);
		  });
	  }
  }
  
})