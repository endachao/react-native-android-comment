import {NativeModules} from 'react-native';

const {ReactNativeAndroidComment} = NativeModules;

export default function () {
    console.log('ReactNativeAndroidComment.getComment');
    return ReactNativeAndroidComment.getComment();
};
