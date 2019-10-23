// pages/criminalsmall/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    initdata:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this
    var type = options.type
    //获取上级的点击事件
    var info = JSON.parse(options.info)
    _this.setData({
      info: info
    })
    _this.askData() 
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  askData: function () {
    var _this = this
    var info = this.data.info;
    wx.request({
      url: "https://www.服务器.site/kg/getDetail?crimeSmall=" + info,
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {
      },
      success: function (res) {
        console.log(res.data)
        console.log(res.data.law)
        console.log(res.data.law.length)
        // console.log(JSON.parse(res.data[0]))// 服务器回包信息     
        // var list = []
        // for (var i = 0; i < res.data.length; i++) {
        //   list.push(JSON.parse(res.data[i]))
        // }
        _this.setData({
          initdata: res.data,
        })
      },
      fail: function (res) {
        console.log(res)// 服务器回包信息   
      }
    })
  }
})