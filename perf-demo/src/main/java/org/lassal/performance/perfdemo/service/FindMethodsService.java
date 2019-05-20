package org.lassal.performance.perfdemo.service;

import org.lassal.performance.perfdemo.domain.KeyValue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.*;

@Component
public class FindMethodsService {

    private final int SET_SIZE = 100000;
    private List<KeyValue> listRepo;
    private Map<Long, Long> mapRepo;

    @PostConstruct
    public void init() {
        this.listRepo = new ArrayList<>(this.SET_SIZE);
        this.mapRepo = new HashMap<>(this.SET_SIZE);

        for (long i = 0; i < this.SET_SIZE; i++) {
            KeyValue value = new KeyValue(i, System.nanoTime());
            this.listRepo.add(value);
            this.mapRepo.put(i, value.getValue());
        }

    }

    public void findInListNTimesSequential(int numberOfSearches) {

        for (int a = 0; a < numberOfSearches; a++) {

                Long key = (long) (numberOfSearches % this.SET_SIZE);

                KeyValue value = this.listRepo.stream()
                        .filter(kv -> key.equals(kv.getValue()))
                        .findFirst()
                        .orElse(null);


/*                KeyValue value = null;
                for(KeyValue kv : this.listRepo){
                    if(key.equals(kv.getValue())){
                        value = kv;
                        break;
                    }
                }
*/

                if (value != null) {
                  //  total = total.add(BigInteger.valueOf(value.getValue()));
                }
        }
    }

    public void findInMapNTimesSequential(int numberOfSearches) {
      //  BigInteger total = BigInteger.valueOf(0L);

        for (long a = 0; a < numberOfSearches; a++) {

                long i = (numberOfSearches % this.SET_SIZE);
                Long value = this.mapRepo.get(i);

                if (value != null) {
          //          total = total.add(BigInteger.valueOf(value));
                }

        }
    }

    public void findInListNTimesRandom(int numberOfSearches) {
      //  BigInteger total = BigInteger.valueOf(0L);
        Random rand = new Random();


        for (int i = 0; i < numberOfSearches; i++) {
            Long key = Long.valueOf(rand.nextInt(this.SET_SIZE));

            /*
            KeyValue value = null;
            for(KeyValue kv : this.listRepo){
                if(key.equals(kv.getValue())){
                    value = kv;
                    break;
                }
            }*/

            KeyValue value = this.listRepo.stream()
                    .filter(kv -> key.equals(kv.getValue()))
                    .findFirst()
                    .orElse(null);


            if (value != null) {
        //        total = total.add(BigInteger.valueOf(value.getValue()));
            }
        }

    }

    public void findInMapNTimesRandom(int numberOfSearches) {
      //  BigInteger total = BigInteger.valueOf(0L);
        Random rand = new Random();

        for (long i = 0; i < numberOfSearches; i++) {
            Long key = Long.valueOf(rand.nextInt(this.SET_SIZE));
            Long value = this.mapRepo.get(key);

            if (value != null) {
        //        total = total.add(BigInteger.valueOf(value));
            }
        }

    }
}
