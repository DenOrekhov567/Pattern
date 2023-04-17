package dev.denny.pattern.entity;

import java.util.HashMap;
import java.util.Map;

public class EntityManager {
    public static Map<String, EntityBase> entities = new HashMap<String, EntityBase>();

    public static void addEntity(String key, EntityBase entity) {
        if (!entities.containsKey(key)) {
            entities.put(key, entity);
        }
    }

    public static EntityBase getEntity(String key) {
        if (entities.containsKey(key)) {
            return entities.get(key);
        }
        return null;
    }
}