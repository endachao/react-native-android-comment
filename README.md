# react-native-android-comment


一个用于获取 Android apk 渠道信息的包

渠道打包流程

后台 PHP 往 apk 写入了一个 zip comment 信息，然后使用此包获取


## Getting started

`$ yarn add git+https://github.com/endachao/react-native-android-comment.git`

## Update

`$ yarn upgrade react-native-android-comment`


## Usage

```javascript
import androidGetComment from 'react-native-android-comment';


androidGetComment().then(res=>{
  console.log('androidGetComment',res)
}).catch(e=>{
  console.log(e)
})

```
