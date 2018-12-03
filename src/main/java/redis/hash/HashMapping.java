package redis.hash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;

import java.util.Map;

public class HashMapping {
    @Autowired
    HashOperations<Object, byte[], byte[]> hashOperations;

    HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

    public void writeHash(String key, Person person) {
        Map<byte[], byte[]> mappedHash = mapper.toHash(person);
        hashOperations.putAll(key, mappedHash);
    }

    public Person loadHash(String key) {
        Map<byte[], byte[]> loadedHash = hashOperations.entries(key);
        return (Person) mapper.fromHash(loadedHash);
    }

    public static void main(String [] args) {
        Person p = new Person();
        p.setFirstName("cloud");
        p.setLastName("chen");

        HashMapping mapping = new HashMapping();
        mapping.writeHash("1000", p);
    }
}
