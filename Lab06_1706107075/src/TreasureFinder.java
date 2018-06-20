import java.util.Scanner;

public class TreasureFinder {

    public static void main(String[] args){
        int mapCount;
        MapDungeon[] maps;
        int maxArtifak = 0;
        int dungeonMaxArtifact=0;
        boolean isExit = false;

        String in = (new Scanner(System.in)).next();
        mapCount = Integer.parseInt(in);
//        System.out.println("jlh : "+jumlahPeta);
        maps = new MapDungeon[mapCount];
        for(int i=0; i< mapCount; i++){
            maps[i] = new MapDungeon();
            maps[i].fillData();
        }

        maxArtifak = 0;
        isExit = false;

        for(int i=0; i< mapCount; i++){
            System.out.println("Peta Dungeon "+(i+1)+"#");
            maps[i].run();
            System.out.println(maps[i].getArtifactCount());

            if(maps[i].isFound()){
                if(maps[i].getArtifactCount()>maxArtifak){
                    dungeonMaxArtifact = i;
                    maxArtifak = maps[i].getArtifactCount();
                }
                isExit = true;
                System.out.println("Bisa keluar");
            }else{
                System.out.println("Tidak bisa keluar");
            }
        }

        if(isExit){
            System.out.println("Dungeon yang dipilih adalah dungeon nomor "+(dungeonMaxArtifact+1));
        }else{
            System.out.println("Flame Princess dan Finn tidak jadi pergi ke dungeon dan pada akhirnya bermain episode Burning Low");
        }
    }
}
