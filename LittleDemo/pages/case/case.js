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
    caseData:'',
    min:80,
    max:1000,
    imgs: [],
    show:"",
    swHeight:'',
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
            quest:res.data
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
    if (this.data.quest.length<80){
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
    }else{
      //获取该问题相关
      this.getAllPageData(this.data.quest)
    }
    
  },
  //点击相关问题
  handleTap: function (e) {
    var _this = this
    var data = e.currentTarget.dataset
    console.log(data.info)    
    //获取该问题相关
    _this.getAllPageData(data.info)

  },
  getAllPageData: function (quest) {
    // 请求数据
    var _this = this;
    _this.setData({
      initQuest: quest,
      currentWordNumber:quest.length
    })
    wx.showLoading({
      title: '正在分析...',
    })
    wx.request({
      url: 'https://www.服务器域名.site/lawpredict/getResult?criminal_case=' + quest,
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {
      },
      success: function (res) {
        console.log(res)// 服务器回包信息
        if (res.statusCode == 200) {
          // 数据处理
          for(var i=0;i<res.data.topK;i++){
            res.data.lawContent[i] = res.data.lawContent[i].replace(/\\n/g, "\n")
            res.data.lawContent[i] = res.data.lawContent[i].replace(/"/g, "")
            res.data.chargeProb[i] = (res.data.chargeProb[i]*100).toFixed(2)+'%'
            res.data.lawProb[i] = (res.data.lawProb[i] * 100).toFixed(2) + '%'
          }
          _this.setData({
            caseData: res.data
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
      }
    })
  },
  //字数限制  
  inputs: function (e) {
    // 获取输入框的内容
    var value = e.detail.value;
    // 获取输入框内容的长度
    var len = parseInt(value.length);
    this.setData({
      quest: value
    })
    //最少字数限制
    if (len <= this.data.min)
      this.setData({
        quest: e.detail.value,
        texts: "请写够字数"
      })
    else if (len > this.data.min)
      this.setData({
        texts: " "
      })

    //最多字数限制
    if (len > this.data.max) return;
    // 当输入框内容的长度大于最大长度限制（max)时，终止setData()的执行
    this.setData({
      currentWordNumber: len //当前字数  
    });
  },
  //印刷体识别
  chooseImg: function () {
    var _this = this;
    wx.chooseImage({
      count: 3,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        var tempFilePaths = res.tempFilePaths;
        _this.setData({
          imgs: tempFilePaths
        });
        wx.uploadFile({
          url: 'https://www.服务器域名.site/judge/GetResult/weChat/uploadImage', //仅为示例，非真实的接口地址
          filePath: tempFilePaths[0],
          name: "file",
          header: {
            "Content-Type": "multipart/form-data"
          },
          formData: {
            "user": "test",
          },
          success: function (res) {
            var data = res.data
            console.log(data)
            wx.showLoading({
              title: '正在识别中...',
            })
            //do something
            wx.request({
              url: 'https://www.服务器域名.site/judge/GetResult/GeneralOCR',
              data: {

              },
              method: 'POST',
              header: {
                "Content-Type": "application/json; charset=utf-8"
              },
              success: function (res) {
                var show = "";
                if (res.data) {
                  console.log(res.data.TextDetections);

                  for (var i = 0; i < res.data.TextDetections.length; i++) {
                    show += res.data.TextDetections[i].DetectedText + "\n";
                  }
                }
                else {
                  show += "未识别到文字"
                }
                console.log(show)
                _this.setData({
                  initQuest: show,
                  quest:show
                })
                _this.textwaring()
              },
              complete:function() {
                wx.hideLoading()
              }


            })
          }
        })
        console.log(tempFilePaths)
      }

    })

  },
  handImg: function () {
    var _this = this;
    wx.chooseImage({
      count: 3,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        var tempFilePaths = res.tempFilePaths;
        _this.setData({
          imgs: tempFilePaths
        });
        wx.uploadFile({
          url: 'https://www.服务器域名.site/judge/GetResult/weChat/uploadImage', //仅为示例，非真实的接口地址
          filePath: tempFilePaths[0],
          name: "file",
          header: {
            "Content-Type": "multipart/form-data"
          },
          formData: {
            "user": "test",
          },
          success: function (res) {
            var data = res.data
            console.log(data)
            wx.showLoading({
              title: '正在识别中...',
            })
            //do something

            wx.request({
              url: 'https://www.服务器域名.site/judge/GetResult/HandWriteOCR',
              data: {

              },
              method: 'POST',
              header: {
                "Content-Type": "application/json; charset=utf-8"
              },
              success: function (res) {
                var show = "";
                console.log(res.data.words_result);
                for (var i = 0; i < res.data.words_result.length; i++) {
                  show += res.data.words_result[i].words + "\n";
                }
                _this.setData({
                  show: show,
                  initQuest: show,
                  quest: show
                })
                _this.textwaring()
              },
              complete: function () {
                wx.hideLoading()
              }
            })
          }
        })
        console.log(tempFilePaths)
      }

    })

  },
  previewImg: function (e) {
    var current = e.target.dataset.src;
    wx.previewImage({
      urls: this.data.imgs,
      current: current,
      success: function (e) {
        console.log("预览成功");
      }
    })
  },
  refresh:function(){
    this.onLoad()
  },
  textwaring:function(){
    var len = this.data.initQuest.length
    //最少字数限制
    if (len <= this.data.min)
      this.setData({
        texts: "请写够字数"
      })
    else if (len > this.data.min)
      this.setData({
        texts: " "
      })

    //最多字数限制
    if (len > this.data.max) return;
    // 当输入框内容的长度大于最大长度限制（max)时，终止setData()的执行
    this.setData({
      currentWordNumber: len //当前字数  
    });
  },
  //点击滑动
  bindchange: function (e) {
    let that = this;
    var query = wx.createSelectorQuery()
    query.select('.sw2').boundingClientRect()
    query.exec(function (res) {
      console.log(res)
      console.log("height" + res[0].height)       // #the-id节点的上边界坐
      console.log(e.detail.current)
      if (e.detail.current == '1') {
        that.setData({
          swHeight: res[0].height
        })
      }else{
        that.setData({
          swHeight: 400
        })
      }
    })
    that.setData({
      currentTab: e.detail.current
    })
  },
  //点击切换，滑块index赋值
  clickTab: function (e) {
    let that = this;
    var query = wx.createSelectorQuery()
    query.select('.sw2').boundingClientRect()
    query.exec(function (res) {
      console.log(res)
      console.log("height" + res[0].height)       // #the-id节点的上边界坐
      console.log(e.currentTarget.dataset.current)
      if (e.currentTarget.dataset.current=='1'){
        that.setData({
          swHeight: res[0].height
        })
      }else {
        that.setData({
          swHeight: 400
        })
      }     
    })
    
    if (that.data.currentTab === e.currentTarget.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab: e.currentTarget.dataset.current
      })
    }
  }
})