package org.example.designPattner.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Pool {

  private Map<String, ObjInfo> map = new HashMap<>();

  public boolean add(String key, ObjInfo obj) {
    if (map.containsKey(key)) {
      return false;
    } else {
      map.put(key, obj);
      return true;
    }
  }

  /**
   * @param key
   * @return
   */
  public Optional<ObjInfo> get(String key) {
    if (this.map.containsKey(key)) {
      return Optional.of(map.get(key));
    }
    return Optional.empty();
  }
}
