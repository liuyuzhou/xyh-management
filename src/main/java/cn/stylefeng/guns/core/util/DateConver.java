package cn.stylefeng.guns.core.util;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DateConver extends BeanUtil {
    /**
     * 对象转Map，不进行驼峰转下划线，不忽略值为空的字段
     *
     * @param bean bean对象
     * @return Map
     */
    public static Map<String, Object> beanToMap(Object bean) {
        return beanToMap(bean, false, false);
    }

    /**
     * 对象转Map
     *
     * @param bean bean对象
     * @param isToUnderlineCase 是否转换为下划线模式
     * @param ignoreNullValue 是否忽略值为空的字段
     * @return Map
     */
    public static Map<String, Object> beanToMap(Object bean, boolean isToUnderlineCase, boolean ignoreNullValue) {
        return beanToMap(bean, new LinkedHashMap<String, Object>(), isToUnderlineCase, ignoreNullValue);
    }
    public static Map<String, Object> beanToMap(Object bean, Map<String, Object> targetMap, final boolean isToUnderlineCase, boolean ignoreNullValue) {
        if (bean == null) {
            return null;
        }

        return beanToMap(bean, targetMap, ignoreNullValue, new Editor<String>() {

            @Override
            public String edit(String key) {
                return isToUnderlineCase ? StrUtil.toUnderlineCase(key) : key;
            }
        });
    }
    /**
     * 对象转Map<br>
     * 通过实现{@link Editor} 可以自定义字段值，如果这个Editor返回null则忽略这个字段，以便实现：
     *
     * <pre>
     * 1. 字段筛选，可以去除不需要的字段
     * 2. 字段变换，例如实现驼峰转下划线
     * 3. 自定义字段前缀或后缀等等
     * </pre>
     *
     * @param bean bean对象
     * @param targetMap 目标的Map
     * @param ignoreNullValue 是否忽略值为空的字段
     * @param keyEditor 属性字段（Map的key）编辑器，用于筛选、编辑key
     * @return Map
     * @since 4.0.5
     */

    public static Map<String, Object> beanToMap(Object bean, Map<String, Object> targetMap, boolean ignoreNullValue, Editor<String> keyEditor) {

        if (bean == null) {
            return null;
        }

        final Collection<BeanDesc.PropDesc> props = BeanUtil.getBeanDesc(bean.getClass()).getProps();

        String key;
        Method getter;
        Object value;
        for (BeanDesc.PropDesc prop : props) {
            key = prop.getFieldName();
            // 过滤class属性
            // 得到property对应的getter方法
            getter = prop.getGetter();
            if (null != getter) {
                // 只读取有getter方法的属性
                try {
                    value = getter.invoke(bean);
                    if (value!=null&&value.toString().contains(" CST ")){
                        Date time =new Date(value.toString());
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        value = sdf.format(time);
                    }
                } catch (Exception ignore) {
                    continue;
                }
                if (false == ignoreNullValue || (null != value && false == value.equals(bean))) {
                    key = keyEditor.edit(key);
                    if (null != key) {
                        targetMap.put(key, value);
                    }
                }
            }
        }
        return targetMap;
    }

    public static String CstToString(String dateString) {
        if (dateString.contains("CST")) {
            Date time = new Date(dateString);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeFormat = sdf.format(time);
            return timeFormat;
        }
        return dateString;
    }
}
