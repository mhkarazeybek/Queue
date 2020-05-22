import java.util.Random;

/*
#EvdeKalTürkiye
Karantinaya özel PIDE KUYRUĞU

    sıra sonu
        
        | ☺ |

        | ☺ |

        | ☺ |

        | ☺ |

    sıra başı

          ☻ (fırıncı)
*/

public class Oven {
    static int front;
    static int rear;
    static Person[] arr;
    static int capacity;
    static int counter;
    public static void main(String[] args) {
        arr = new Person[]{new Person("Gökhan",true),       
        new Person("Abdulkerim",true), 
        new Person("Mehmet Faruk",true), 
        new Person("Muhammed Hüseyin",true),
        new Person("Mustafa",false),
        new Person("Sena",true),
        new Person("Zehra Şevval",true),
        new Person("Bilge Sena",true) ,null,null};
        capacity=10;
        front=0;
        rear=0;
        counter=0;
        
        Random cırak = new Random();
        
        for (Person person : arr)
            setPerson2Oven(person);

        setPerson2Oven(new Person("Melike",true));
        setPerson2Oven(new Person("Sinem",true));
        setPerson2Oven(new Person("Tuğce",true));
        
        display(0);
        System.out.println("-----------------Pide Satışı Başladı---------");
        giveMyPide(cırak.nextInt(11));
        System.out.println("-----------------Satış Yapıldı---------------");
        setPerson2Oven(new Person("Taksim Dayı",false));
        display(0);
        System.out.println("-----------------Pide Satışı Başladı---------");
        giveMyPide(cırak.nextInt(11));
        System.out.println("-----------------Satış Yapıldı---------------");
        setPerson2Oven(new Person("Veyahut Dayı",true)); 
        display(0);
        System.out.println("-----------------Pide Satışı Başladı---------");
        giveMyPide(cırak.nextInt(11));
        System.out.println("-----------------Satış Yapıldı---------------");
        display(0);
        System.out.println("-----------------Pide Satışı Başladı---------");
        giveMyPide(cırak.nextInt(11));
        System.out.println("-----------------Satış Yapıldı---------------");
        display(0);
        System.out.println("-----------------Pide Satışı Başladı---------");
        giveMyPide(cırak.nextInt(11));
        System.out.println("-----------------Satış Yapıldı---------------");
        display(0);
        System.out.println("-----------------Pide Satışı Başladı---------");
        giveMyPide(cırak.nextInt(11));
        System.out.println("-----------------Satış Yapıldı---------------");
        display(0);
        System.out.println("-----------------Pide Satışı Başladı---------");
        giveMyPide(cırak.nextInt(11));
        System.out.println("-----------------Satış Yapıldı---------------");
        display(0);

    }

    public static void display(int c){
        if(isEmpty() || arr[c]==null)
            return;
        System.out.println(arr[c].getName());
        display(c+1);
    }

    public static void setPerson2Oven(Person person){
        if(isFull()){   
            System.out.println(person.getName()+" Sıra Doldu! Lütfen Sosyal Mesafeye dikkat edelim. Vaktiniz varsa ilerde bekleyiniz.");
            return;
        }
        if(person != null && !person.checkMask()){  // 1 && 1 = 1, 0 && 1 = 0, 0 & 1 = 0
            System.out.println(person.getName()+" Lütfen Maske Takınız.");
            return;
        }
        if(person!=null){
            arr[rear++]=person;
            counter++;
        }
    }

    public static void giveMyPide(int quantity){
        if(isEmpty()){
            System.out.println("Sırada kimse yok, Pide Yapımı Durdu!");
            return;
        }
        arr[front].setPideCount(quantity);
        System.err.println("Yavaş lan gaç tane alıyorsun: "+arr[front].getName()+": "+arr[front].getPideCount());
        arr[front++]=null;
        counter--;
        restartQueue();
    }


    public static boolean isFull(){return getSize()==capacity-1;}

    public static int getSize(){return counter;}

    public static boolean isEmpty(){return getSize()==0;}


    public static void restartQueue(){ 
        Person[] temp = new Person[capacity];
        for (int i = 0; i < temp.length-1; i++) 
            temp[i]=arr[i+1];
        arr=temp;
        front-=1;   
        rear-=1;
    }
}