import type {ViewProps} from 'ViewPropTypes';
import type {HostComponent} from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import {DirectEventHandler} from 'react-native/Libraries/Types/CodegenTypes';

type Event = Readonly<{
  text?: string;
}>;

export interface NativeProps extends ViewProps {
  text?: string;
  // add other props here
  onClickHandler?: DirectEventHandler<Event>; ////Event name should start with on
}

export default codegenNativeComponent<NativeProps>(
  'RTNCenteredButton',
) as HostComponent<NativeProps>;
