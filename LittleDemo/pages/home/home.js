Page({
  data: {
    inputShowed: false,
    inputVal: "",
    infoList:[]
  },
  showInput: function () {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },
  inputTyping: function (e) {
    this.setData({
      inputVal: e.detail.value
    });
    console.log(this)
  },
  dataRend:function(e){
    var keyWords = e.detail.value;
    var _this = this;
    console.log(keyWords)
    wx.request({
      url: 'data.json',
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {        
      },
      success: function (res) {
        console.log(res)// 服务器回包信息
      },
      fail:function(res){
        console.log(res)// 服务器回包信息
        _this.setData({infoList: [
          {
            "chapter": "第一章",
            "title": "中华人名共和国刑法，第一章第一节"
          },
          {
            "chapter": "第二章",
            "title": "中华人名共和国刑法，第二章第一节"
          },          
        ]})
        console.log(_this.infoList)
      }
    })
  },
  handleTap:function(e){    
    var data = e.currentTarget.dataset
    console.log(data.info)
    wx.navigateTo({
      url: '../../pages/detail/detail?info='+data.info.title,
    })
  }

});