package jichu.JVM.OOM;//package jichu.JVM.OOM;
//
//
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
///**
// * @Author: liangxiao
// * @Date: Created in 15:01 2018/9/17
// */
//public class JavaMethodAreaOOM {
//    public static void main(String[] args) {
//        while (true) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(OOMObject.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                    return proxy.invokeSuper(obj, args);
//                }
//            });
//            enhancer.create();
//        }
//    }
//    static class OOMObject {
//    }
//}
