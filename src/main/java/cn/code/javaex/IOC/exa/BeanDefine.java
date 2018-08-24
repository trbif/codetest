package cn.code.javaex.IOC.exa;

public class BeanDefine {
    String id;
    String className;

    public BeanDefine(String id,String className){
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }


    public String getClassName() {
        return className;
    }

}
