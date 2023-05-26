package com.alin.messageByme;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author：raozl
 * @Date：2023/5/9 10:02
 */
@SpringBootTest(classes = ParseJsonTest.class)
public class ParseJsonTest {

    @Test
    public void jsonStrParse() {
        String str = "[{\"modules\":[{\"info\":[{\"choices\":[\"fedavg\"],\"inputType\":\"select\",\"name\":\"调用方法\",\"param\":\"method\",\"type\":\"str\",\"value\":\"fedavg\"},{\"choices\":[\"SGD\",\"Adam\",\"AdaGrad\",\"RMSProp\",\"Adadelta\",\"Adamax\",\"ASGD\",\"LBFGS\",\"Rprop\"],\"inputType\":\"select\",\"name\":\"优化方式\",\"param\":\"optim\",\"type\":\"str\",\"value\":\"SGD\"},{\"name\":\"学习率\",\"param\":\"lr\",\"type\":\"float\",\"value\":0.01},{\"name\":\"训练轮数\",\"param\":\"epoch\",\"type\":\"int\",\"value\":1},{\"name\":\"标签位置\",\"param\":\"label_num\",\"type\":\"int\",\"value\":1},{\"choices\":[\"L1Loss\",\"MSELoss\",\"CrossEntropyLoss\",\"CTCLoss\",\"NLLLoss\",\"PoissonNLLLoss\",\"GaussianNLLLoss\",\"KLDivLoss\",\"BCELoss\",\"BCEWithLogitsLoss\",\"MarginRankingLoss\",\"HingeEmbeddingLoss\",\"MultiLabelMarginLoss\",\"HuberLoss\",\"SmoothL1Loss\",\"SoftMarginLoss\",\"MultiLabelSoftMarginLoss\",\"CosineEmbeddingLoss\",\"MultiMarginLoss\",\"TripletMarginLoss\",\"TripletMarginWithDistanceLoss\"],\"inputType\":\"select\",\"name\":\"损失函数\",\"param\":\"loss\",\"type\":\"str\",\"value\":\"MSELoss\"}]}],\"multi\":false,\"role\":\"\",\"shared\":true},{\"group\":\"hosts\",\"modules\":[{\"info\":[{\"name\":\"节点标识\",\"param\":\"node_name\",\"type\":\"query\"}],\"query\":\"deployNode\"}],\"multi\":true,\"role\":\"hosts节点\",\"shared\":false},{\"group\":\"clients\",\"modules\":[{\"info\":[{\"name\":\"节点标识\",\"param\":\"node_name\",\"type\":\"query\"}],\"query\":\"deployNode\"}],\"multi\":true,\"role\":\"clients节点\",\"shared\":false}]";
        JSONArray jsonArray = null;
        try {
            jsonArray = JSON.parseArray(str);
        } catch (Exception e) {
            System.out.println("================该JSON字符串为json对象，不是json数组========================");
            JSONObject jsonObject = JSON.parseObject(str);
            Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String key = entry.getKey();
                Object value = entry.getValue();
            }
            e.printStackTrace();
        }
        assert jsonArray != null;
        for (Object o : jsonArray) {
            JSONObject obj = (JSONObject) o;
            Set<Map.Entry<String, Object>> entrySet = obj.entrySet();
            for (Map.Entry<String, Object> stringObjectEntry : entrySet) {
                String key = stringObjectEntry.getKey();
                Object value = stringObjectEntry.getValue();
                // value可能还是JSONArray，所以要做一次判断，如果是Array类型，就继续遍历
                if (value instanceof JSONArray) {
                    JSONArray array = (JSONArray) value;
                    for (Object jsonItem : array) {
                        if (jsonItem instanceof JSONObject) {
                            JSONObject jsonObject = (JSONObject) jsonItem;
                            for (Map.Entry<String, Object> objectEntry : jsonObject.entrySet()) {
                                String paramName = objectEntry.getKey();
                                Object paramValue = objectEntry.getValue();
                                System.out.println(paramName);
                                System.out.println(paramValue);
                                // 获取value的类型 todo
                            }
                        }
                    }
                } else if (value instanceof JSONObject) {
                    // value如果是JSONObject类型，那也要检查一下内部是不是有Array类型，继续向下遍历
                    JSONObject object = (JSONObject) value;
                    for (Map.Entry<String, Object> objectEntry : object.entrySet()) {
                        String key1 = objectEntry.getKey();
                        Object value1 = objectEntry.getValue();
                        System.out.println(key1);
                        System.out.println(value1);
                    }
                } else {
                    System.out.println("不在向下遍历，结果为：" + value.toString());
                    Class<?> aClass = value.getClass();
                    System.out.println("value的type：" + aClass.toString());
                }

            }

        }

    }

    @Test
    public void tesss() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONArray info = new JSONArray();
        JSONObject noName = new JSONObject();
        noName.put("parpm", "class");
        noName.put("name", "调用类");
        noName.put("type", "str");
        noName.put("value", "LinearWrapper");
        info.add( noName);
        JSONObject object = new JSONObject();
        object.put("info", info);
        jsonArray.add(object);
        jsonObject.put("model", jsonArray);
        System.out.println(jsonObject);

    }

    public String getParamType(Object obj) {
        String paramType = null;
        if (obj != null) {
            Class<?> aClass = obj.getClass();
            paramType = aClass.toString();
            System.out.println("反射得到的结果为:" + paramType);
        }
        if (obj != null) {
            if (obj instanceof String) {
                paramType = "String";
            } else if (obj instanceof Integer) {
                paramType = "Integer";
            } else if (obj instanceof Long) {
                paramType = "Long";
            } else if (obj instanceof Double) {
                paramType = "Double";
            } else if (obj instanceof BigDecimal) {
                paramType = "BigDecimal";
            } else if (obj instanceof Float) {
                paramType = "Float";
            } else if (obj instanceof Boolean) {
                paramType = "Boolean";
            } else if (obj instanceof Double[]) {
                paramType = "Double[]";
            } else if (obj instanceof Date) {
                paramType = "Date";
            } else if (obj instanceof Long[]) {
                paramType = "Long[]";
            } else if (obj instanceof String[]) {
                paramType = "String[]";
            } else {
                paramType = "Map<String,Object>";
            }
        } else {
            paramType = "null";
        }
        return paramType;
    }
}
