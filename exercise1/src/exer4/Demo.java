package exer4;

interface Inter {
    void show(int a, int b);

    void func();
}

class Demo {
    public static void main(String[] args) {

        Inter in = new Inter(){
            @Override
            public void show(int a, int b) {

            }

            @Override
            public void func() {

            }
        };
        in.show(1,2);
        in.func();
    }

    }