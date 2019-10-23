// pages/question/question.js
const recorderManager = wx.getRecorderManager();
const ip = "58.87.107.231";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    quest:"",
    initAnswer:"",
    initList:"",
    quest:"",
    recordingTimeqwe: 0,//录音计时
    setInter: "",//录音名称,
    loading: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    console.log(this.data.quest)
    wx.request({
      url: 'https://www.服务器域名.site/qa/randomGetDemoQuestion',
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {
      },
      success: function (res) {
        console.log(res)// 服务器回包信息
        if (res.statusCode == 200) {
          _this.setData({
            quest: res.data
          })
          //获取该问题相关
          _this.getAllPageData(res.data)
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
  searchQuest:function(e){
    console.log("输入框输入"+e.detail.value)
    this.setData({
      quest: e.detail.value
    })
    console.log("quest"+this.data.quest)
    
  },
  //分析相关问题
  handleSearch:function(){
    console.log(this.data.quest)
    //获取该问题相关
    this.getAllPageData(this.data.quest)
    //设置对话框字符
    this.setData({
      quest: this.data.quest
    })
  },
  //点击相关问题
  handleTap: function (e) {
    var _this = this
    var data = e.currentTarget.dataset
    console.log(data.info)  
    //获取该问题相关
    _this.getAllPageData(data.info)
    //设置对话框字符
    _this.setData({
      quest: data.info
    })
    console.log(this.data.quest)
    wx.pageScrollTo({
      scrollTop: 0
    }) 
  },
  getAllPageData:function(quest){
    // 请求数据
    var _this = this;
    wx.showLoading({
      title: '正在加载...',
    })
    wx.request({
      url: 'https://www.服务器域名.site/qa/getAnswerOfQuestion?question=' + quest,
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {
      },
      success: function (res) {
        console.log(res)// 服务器回包信息
        if (res.statusCode == 200 && res.data.result == "success") {
          _this.setData({
            initAnswer: res.data.successData[0]['answer'].replace(/\s*/g, ""),
            initList: res.data.successData
          })
        }else{
          wx.showModal({
            title: '抱歉',
            content: '请重新描述问题',
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
  //录音计时器
  recordingTimer: function () {
    var that = this;
    //将计时器赋值给setInter
    that.data.setInter = setInterval(
      function () {
        var time = that.data.recordingTimeqwe + 1;
        that.setData({
          recordingTimeqwe: time
        })
      }
      , 1000);
  },
  //语音识别
  startRecode: function () {
    var s = this;

    console.log("start");
    const options = {
      duration: 60000, //指定录音的时长，单位 ms，最大为10分钟（600000），默认为1分钟（60000）
      sampleRate: 16000, //采样率
      numberOfChannels: 1, //录音通道数
      encodeBitRate: 96000, //编码码率
      format: 'mp3', //音频格式，有效值 aac/mp3
      frameSize: 50, //指定帧大小，单位 KB
    }
    //开始录音计时   
    s.recordingTimer();
    recorderManager.start(options);
    recorderManager.onStart(() => {
      console.log('。。。开始录音。。。')
      wx.showLoading({
        title: '正在录音...',
      })
    });
    //错误回调
    recorderManager.onError((res) => {
      console.log(res);
    })
  },
  endRecode: function () {//结束录音 
    var that = this;
    recorderManager.stop();
    recorderManager.onStop((res) => {
      console.log('。。停止录音。。', res.tempFilePath)
      const { tempFilePath } = res;
      //结束录音计时  
      clearInterval(that.data.setInter);
      var urls = "https://www.服务器域名.site/judge/GetResult/weChat/uploadVoice";
      wx.uploadFile({
        url: urls,
        filePath: tempFilePath,
        name: 'file',
        header: {
          'content-type': 'multipart/form-data'
        },
        formData: {
          recordingtime: that.data.recordingTimeqwe,
          topicid: that.data.topicid,
          userid: 1,
          praisepoints: 0
        },
        success: function (ress) {
          console.log(res);
          wx.hideLoading()
          wx.showToast({
            title: '录音完成',
            icon: 'success',
            duration: 2000,
          })
          wx.request({
            url: 'https://www.服务器域名.site/judge/GetResult/Sentence',
            data: {
            },
            method: 'POST',
            header: {
              "Content-Type": "application/json; charset=utf-8"
            },
            success: function (res) {
              var show = "识别结果：\n";
              console.log(res.data.Result);
              show += res.data.Result;

              that.setData({
                show: show,
                quest: res.data.Result,
                quest: res.data.Result
              })
            }
          })


        },
        fail: function (res) {
          console.log(res);
          wx.showModal({
            title: '提示',
            content: "网络请求失败，请确保网络是否正常",
            showCancel: false,
            success: function (res) {

            }
          });
          wx.hideToast();
        }
      });
    }, 1000)

  },
  refresh: function () {
    this.onLoad()
  }
})