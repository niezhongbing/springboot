var app5 = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue1.js!'
  },
  mounted:function(){
		// 根据官方文档添加$nextTick钩子，以保证该vm已被实例加载
		this.$nextTick(function(){
			// 调用getJson方法(已经在methods内定义)
			this.reverseMessage();
		})
	},
  methods: {
    reverseMessage: function () {
      this.message = this.message.split('').reverse().join('')
    }
  }
  
})