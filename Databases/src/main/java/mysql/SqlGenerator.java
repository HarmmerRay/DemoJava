package mysql;

import lombok.Getter;

/**
 * @description: 增删改查sql语句生成器.
 * @author: HammerRay
 * @date: 2023/11/4 下午11:45
 */
@Getter
public class SqlGenerator {

    private final String tableName;

    public SqlGenerator(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 自动生成sql语句
     * @paramType:
     * @param obj,tableName 插入的整个对象，和目标表名字
     * @returnType:
     * @author: GodHammer
     * @date: 2023-11-04 下午11:46
     * @version: v1.0
     */
    public String insertGenerate(Object obj){return "";}

    public String deleteGenerate(Object obj){return "";}

    public String updateGenerate(Object obj){return "";}

    public String selectOneGenerate(Object obj){return "";}

    /**
     *
     * description:
     * @paramType [java.lang.String]
     * @param entityWithJsonProperty:
     * @returnType: java.lang.String
     * @author: GodHammer
     * @date: 2023-11-19 下午3:16
     */
    public String resultMappingGenerate(String entityWithJsonProperty){return "";}
}

/**
 *  用这种格式的entityWithJsonProperty
 *     @JsonProperty("vc_id")
 *     private String vcId;
 *     @JsonProperty("vc_create_time")
 *     private Timestamp vcCreateTime;
 *     @JsonProperty("vc_operation_type")
 *     private short vcOperationType;
 *
 *     @JsonProperty("vc_user_name")
 *     private String vcUserName;
 *     @JsonProperty("vc_password")
 *     private String vcPassword;
 *     @JsonProperty("vc_picture_code")
 *     private String vcPictureCode;
 *
 *     @JsonProperty("vc_telephone")
 *     private String vcTelephone;
 *     @JsonProperty("vc_telephone_code")
 *     private String vcTelephoneCode;
 *
 *     @JsonProperty("vc_email")
 *     private String vcEmail;
 *     @JsonProperty("vc_email_code")
 *     private String vcEmailCode;
 *     自动生成 <resultMap></resultMap>标签下这种格式的文本
 *         <result column="vc_id" property="vcId"/>
 *         <result column="vc_create_time" property="vcCreateTime"/>
 *         <result column="vc_operation_type" property="vcOperationType"/>
 *
 *         <result column="vc_user_name" property="vcUserName"/>
 *         <result column="vc_password" property="vcPassword"/>
 *         <result column="vc_picture_code" property="vcPictureCode"/>
 *
 *         <result column="vc_telephone" property="vcTelephone"/>
 *         <result column="vc_telephone_code" property="vcTelephoneCode"/>
 *
 *         <result column="vc_email" property="vcEmail"/>
 *         <result column="vc_email_code" property="vcEmailCode"/>
 *
 * 或者 最牛逼的方法: 一个配置文件.yml or .properties
 *
 *         <mapper>.namespace = ""
 *         <mapper>.<resultMap>.id = ""
 *         <mapper>.<resultMap>.type = ""
 *         <mapper>.<resultMap>.<result>.column = "" //多个用 , 隔开
 *         <mapper>.<resultMap>.<result>.property = "" //多个用 , 隔开  上下一定要对应哦
 *         <mapper>.<insert>.id = ""
 *         <mapper>.<insert>.parameterType = ""
 *
 *         根据这个配置文件自动生成 用于mybatis的xxx.xml文件的文件内容
 */