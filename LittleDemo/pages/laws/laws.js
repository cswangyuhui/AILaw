Page({
  data: {
    currentTab: 0, //预定的位置
    inputShowed: false,
    inputVal: "",
    inputShowed2: false,
    inputVal2: "",
    infoList: [],
    resultList:[],
    laws: ["刑法", "道路安全交通法", "劳动法", "新交规驾驶证扣分细则", "婚姻法", "民事诉讼法", "治安管理处罚法", "住房公积金管理条例", "劳动合同法", "消费者权益保护法", "保险法","劳动者权益保护法",""],
    lawIndex: 0,
    lawname:'criminal',
    criminalList:[]
  },
  /**
 * 生命周期函数--监听页面加载
 */
  onLoad: function (options) {    
    var _this = this;
    _this.getOneLaw()
    _this.getCriminalList()
  },
  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    this.onLoad()
    wx.stopPullDownRefresh()
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
  dataRend: function (e) {
    var keyWords = e.detail.value;
    var _this = this;
    console.log(keyWords)
    var send = JSON.stringify({
      keywords: keyWords
    })
    console.log(this.data.lawname)
    wx.navigateTo({
      url: '../../pages/detail/'+_this.data.lawname+'/detail?info=' + send + '&type=' + 'search',
    })
  },
  // handleTap: function (e) {
  //   var data = e.currentTarget.dataset
  //   console.log(data.info)
  //   wx.navigateTo({
  //     url: '../../pages/detail/detail?info=' + data.info.title,
  //   })
  // },
  gotodetailpart: function (e) {
    var _this =this;
    var data = e.currentTarget.dataset
    var info = JSON.stringify(data.info)
    console.log(data.info)
    console.log('../../pages/detail/' + _this.data.lawname +'/detail?info=' + info + '&type=' + 'partNum')
    wx.navigateTo({
      url: '../../pages/detail/' + _this.data.lawname +'/detail?info=' + info + '&type=' +'partNum',
    })
  },
  gotodetailchapter: function (e) {
    var _this =this;
    var data = e.currentTarget.dataset
    var info = JSON.stringify(data.info)
    console.log(data.info)
    console.log('../../pages/detail/' + _this.data.lawname +'/detail?info=' + info + '&type=' + 'chapterNum')
    wx.navigateTo({
      url: '../../pages/detail/' + _this.data.lawname +'/detail?info=' + info + '&type=' + 'chapterNum',
    })
  },
  gotodetailsection: function (e) {
    var _this = this;
    var data = e.currentTarget.dataset
    var info = JSON.stringify(data.info)
    console.log(data.info)
    console.log('../../pages/detail/' + _this.data.lawname +'/detail?info=' + info + '&type=' + 'sectionNum')
    wx.navigateTo({
      url: '../../pages/detail/' + _this.data.lawname +'/detail?info=' + info + '&type=' + 'sectionNum',
    })
  },
  bindLawChange: function (e) {
    console.log('picker country 发生选择改变，携带值为', e.detail.value);
    var alawname
    console.log(e.detail.value)    
    var c = e.detail.value
    // if (c=='0'||c=='1'||c=="2"||c=='3'){
      switch (e.detail.value) {
        case ("0"): alawname = 'criminal'; console.log('xx'); break;
        case ("1"): alawname = 'traffic'; console.log('xx2'); break;
        case ("2"): alawname = 'labor'; break;
        case ("3"): alawname = 'trafficscore'; console.log('xx2'); break;
        case ("4"): alawname = 'marriage'; break;
        case ("5"): alawname = 'civil';break;
        case ("6"): alawname = 'security'; break;
        case ("7"): alawname = 'fund'; break;
        case ("8"): alawname = 'work'; break;
        case ("9"): alawname = 'consume'; break;
        case ("10"): alawname = 'insurance'; break;
        case ("11"): alawname = 'protect'; break;

        default: alawname = 'criminal';
      }
      console.log(alawname)
      this.setData({
        lawIndex: e.detail.value,
        lawname: alawname
      })
      this.getOneLaw()
    // }else{
    //   wx.showToast({
    //     title: '敬请期待!',
    //     icon: 'none',
    //     duration: 1500
    //   });
    // }
    
  },
  getOneLaw:function(){
    var _this = this;
    console.log(this.data.lawIndex)
    var law_url
    console.log(this.data.lawIndex)
    switch(this.data.lawIndex){
      case ("0"): law_url ="https://www.服务器域名.site/criminalsearch/getLawTable";break;
      case ("1"): law_url = "https://www.服务器域名.site/trafficsearch/getLawTable"; break;
      case ("2"): law_url = "https://www.服务器域名.site/laborsearch/getLaborLawTable"; break;
      case ("3"): law_url = "https://www.服务器域名.site/trafficscoresearch/getTrafficScoreLawTable"; break;
      case ("4"): law_url = "https://www.服务器域名.site/marriagesearch/getMarriageLawTable"; break;
      case ("5"): law_url = "https://www.服务器域名.site/civilsearch/getLawTable"; break;
      case ("6"): law_url = "https://www.服务器域名.site/securitysearch/getLawTable"; break;
      case ("7"): law_url = "https://www.服务器域名.site/fundsearch/getLaborLawTable"; break;
      case ("8"): law_url = "https://www.服务器域名.site/contractsearch/getLawTable"; break;
      case ("9"): law_url = "https://www.服务器域名.site/consumersearch/getConsumerLawTable"; break;
      case ("10"): law_url = "https://www.服务器域名.site/insurancesearch/getLawTable"; break;
      case ("11"): law_url = "https://www.服务器域名.site/protectsearch/getLawTable"; break;  
        
      default: law_url = "https://www.服务器域名.site/criminalsearch/getLawTable";
    }
    wx.request({
      url: law_url,
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {
      },
      success: function (res) {
        console.log(res)// 服务器回包信息    
        _this.setData({
          infoList: res.data
        })
      },
      fail: function (res) {
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
  //第二页
  showInput2: function () {
    this.setData({
      inputShowed2: true
    });
  },
  hideInput2: function () {
    this.setData({
      inputVal2: "",
      inputShowed2: false
    });
  },
  clearInput2: function () {
    this.setData({
      inputVal2: ""
    });
  },
  inputTyping2: function (e) {
    this.setData({
      inputVal2: e.detail.value
    });
    console.log(this)
  },
  //点击滑动
  bindchange: function (e) {
    let that = this;
    that.setData({
      currentTab: e.detail.current
    })
  },
  //点击切换，滑块index赋值
  clickTab: function (e) {
    let that = this;
    if (that.data.currentTab === e.currentTarget.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab: e.currentTarget.dataset.current
      })
    }
  },
  //罪名部分
  getCriminalList:function(){
    var _this = this;
    wx.request({
      url: "https://www.服务器域名.site/kg/getTable",
      method: 'get',
      header: { 'content-type': 'application/json' },
      data: {
      },
      success: function (res) {
        console.log(res)// 服务器回包信息    
        _this.setData({
          criminalList: res.data
        })
      },
      fail: function (res) {
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
  //到小罪名
  gotocriminalsmall:function(e){
    var _this = this;
    var data = e.currentTarget.dataset
    var info = JSON.stringify(data.info)
    console.log(data.info)
    wx.navigateTo({
      url: '../../pages/criminalsmall/criminalsmall?info=' + info,
    })
  },
  dataRend2: function (e) {
    var keyWords = e.detail.value;
    var _this = this;
    console.log(keyWords)
    var send = JSON.stringify({
      keywords: keyWords
    })
    console.log(send)
    wx.navigateTo({
      url: '../../pages/criminalsmall/searchresult/searchresult?info=' + send,
    })
  },

  // reForm:function(data){
  //   var firstPart = []
  //   var secondPart = []    
  //   for(var i=0;i<data.length;i++){
  //     if(i.partnum==1){
  //       firstPart.push(i)
  //     }else{
  //       secondePart.push(i)
  //     }
  //   }
  //   var all = {
  //     firstPart : firstPart,
  //     secondPart: secondPart
  //   }
  //   console.log(all)
  // }

});