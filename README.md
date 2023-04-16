# Pattern
Pattern — это плагин для Nukkit и PowerNukkitX, который помогает с быстрым созданием летающих текстов, NPC и др.  

## Примеры использования
- Создание NPC
``` java
    //Создадим процедуру, с видимостью только внутри класса
    //Я её вызываю в onEnable
    private void registerComponents() {
        //Создадим экземпляр класса локации, где NPC будет располагаться
        Location location = new Location(-41.5, 33, -38.5, 90, 0, getServer().getLevelByName("spawn"));
        
        //Загрузим чанки в этой локации для успешного спавна
        EntityFactory.prepare(location);
        
        //Создадим экземпляр класса NPC для дальнейшей работы
        NPC npc = EntityFactory.createNPC(location, "Test_Hologram1");
        //Установим скин этому NPC
        npc.setSkin(Utils.from(new File(getDataFolder() + "").toPath().resolve("skin.png")));
        
        //Установим параметр, отвечающий за обратную связь при его ударе
        npc.setController((clickedNPC, player) -> player.sendMessage("lol"));
        
        //Заспавним NPC
        npc.build();
    }
```
- Создание летающего текста(Hologram)
``` java
    //Создадим процедуру, с видимостью только внутри класса
    //Я её вызываю в onEnable
    private void registerComponents() {
        //Создадим экземпляр класса локации, где Hologram будет располагаться
        Location location = new Location(-41.5, 33, -38.5, 90, 0, getServer().getLevelByName("spawn"));
        
        //Загрузим чанки в этой локации для успешного спавна
        EntityFactory.prepare(location);

        //Создадим экземпляр класса Hologram для дальнейшей работы
        Hologram hologram = EntityFactory.createHologram(location, "Test_NPC1");
        //Установим ему параметр text
        hologram.setText("Hologram text");
        
        //Заспавним Hologram
        hologram.build();
    }
```
## Примечания
Плагин использовать только для разработки, как библиотеку
