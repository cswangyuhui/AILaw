Page({
  data: {
    currentTab: 0 //预定的位置
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
  }
})