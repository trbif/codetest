package cn.code.javaex.threadlocal;

/**
 * @ProjectName: codetest
 * @Description: https://blog.csdn.net/Oeljeklaus/article/details/80545749
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/24 10:44
 * @Version: 1.0.0
 */
public class TestPerson {
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值\

    private static ThreadLocal<Person> seqNum = new ThreadLocal<Person>() {
        public Person initialValue() {
            return new Person("start");
        }
    };

    // ②获取下一个序列值
    public Person getNextNum() {
        seqNum.set(new Person(seqNum.get().getName() + "1"));
        //System.out.println();
        return seqNum.get();
    }


    public  ThreadLocal<Person> getThreadLocal()
    {
        return seqNum;
    }

    public static void main(String[] args) {
        TestPerson sn = new TestPerson();
        // ③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private TestPerson sn;

        public TestClient(TestPerson sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                // ④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + sn.getNextNum().getName() + "]"+sn.getThreadLocal().get().hashCode());
            }
        }
    }
}
