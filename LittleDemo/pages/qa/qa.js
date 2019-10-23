const ip = "58.87.107.231";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    initQuest: "",
    initAnswer: "",
    initList: "",
    quest: "",
    qaData: '',
    min: 80,
    max: 1000,
    imgs: [],
    show: "",
    currentTab: 0 //预定的位置
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    wx.request({
      url: 'https://www.服务器域名.site/lawpredict/randomGetDemoCase',
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {
      },
      success: function (res) {
        console.log(res)// 服务器回包信息
        if (res.statusCode == 200) {
          _this.setData({
            initQuest: res.data,
            quest: res.data
          })
          //获取该问题相关
          _this.getAllPageData(res.data)
        }
      },
      fail: function (res) {
        console.log(res)// 服务器回包信息        
      }
    })

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
    this.onLoad()
    wx.stopPullDownRefresh()
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
  //保存输入框内容
  searchQuest: function (e) {
    this.setData({
      quest: e.detail.value
    })
  },
  //分析相关问题
  handleSearch: function () {
    console.log(this.data.quest)
    if (this.data.quest.length < 80) {
      wx.showModal({
        title: '注意',
        content: '如果输入少于80个汉字，可能无法得到准确答案，建议您使用法律问答功能。',
        confirmText: "确定",
        cancelText: "取消",
        success: function (res) {
          console.log(res);
          if (res.confirm) {
            console.log('确定')
          } else {
            console.log('取消')
          }
        }
      });
    } else {
      //获取该问题相关
      this.getAllPageData(this.data.quest)
    }

  },
  getAllPageData: function (quest) {
    // 请求数据
    var _this = this;
    _this.setData({
      initQuest: quest,
      currentWordNumber: quest.length
    })
    // wx.showLoading({
    //   title: '正在更新...',
    // })
    // this.onPullDownRefresh()
    wx.showNavigationBarLoading()
    wx.request({
      url: 'https://www.服务器域名.site/kg/getKnowledges',
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {
      },
      success: function (res) {
        console.log(res)// 服务器回包信息
        if (res.statusCode == 200) {          
          _this.setData({
            qaData: res.data
          })
        }
      },
      fail: function (res) {
        console.log(res)// 服务器回包信息
        wx.showModal({
          title: '抱歉',
          content: '出现了一些错误请重新尝试',
          confirmText: "确定",
          cancelText: "取消",
          success: function (res) {
            console.log(res);
            if (res.confirm) {
              console.log('确定')
            } else {
              console.log('取消')
            }
          }
        })
      },
      complete: function () {
        wx.hideLoading()
        wx.hideNavigationBarLoading()
      }
    })
  }, 
  refresh: function () {
    this.onLoad()
  }
})