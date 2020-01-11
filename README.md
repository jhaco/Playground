# Playground

###### A 1.15.1 Fabric ModLoader custom port of features and items from older Minecraft mods.
###### The Playground is my personal [Fabric](https://fabricmc.net/) mod learning & development testing ground for Minecraft version 1.15.1. I will be using a pre-existing [project](https://github.com/fabric-community/the-hallow) by The Fabric Community as a template for organizing the project's components.

#### Progress:

|Mod|Progress|Task Update|
|---|--------|------|
|[Wearable Backpacks](https://www.curseforge.com/minecraft/mc-mods/wearable-backpacks)|50%|Added CottonMC's LibGui library. The backpack is now a fully functional storage block complete with an inventory GUI. Now to figure out how to make it portable.|
|[AbyssalCraft](https://www.curseforge.com/minecraft/mc-mods/abyssalcraft) Mobs|30%|Successfully registered/rendered: 4 hostile entities.|
|[BetterDroppedItems](https://www.curseforge.com/minecraft/mc-mods/better-dropped-items)|100%|Successfully translated from 1.14 to 1.15.|

#### Other Features:

###### Random features implemented for fun or to test some code.

|Feature|Description|
|-------|-----------|
|Perpetual Rainfall|Added code so the overworld always rain. Only turns off by using `/weather clear` cheat.|

#### Setup:
* Install a preferred IDE and a Java Development Kit (JDK) for Java 8 or Java 11: https://adoptopenjdk.net/.
* Fabric mod development environment setup instructions can be found here: https://fabricmc.net/wiki/tutorial:setup.
###### Personal note: the onsite tutorials are helpful but also outdated and scuffed. I might consider writing my own guide and posting on Github Pages to document my journey. I also need to stop being lazy and push changed files one-by-one to keep track of individual changes.

---

<details open>
  <summary>01/10/2020 Version 2.1</summary>
  
  + Added translation so descriptions appear normal in-game.

</details>

<details close>
  <summary>01/08/2020 Version 2.0</summary>
  
  + Fully translated Draylar's BetterDroppedItems from mc1.14 to mc1.15. Whew!
  + Added a feature that makes the Overworld constantly rain.
  
</details>

<details close>
  <summary>01/01/2020 Version 1.4</summary>
  
  + Renamed util folder to api.
  + Fully registered 3 Shadow mobs - hostile AbyssalCraft entities - with custom models, sounds, drops, egg and AI.
  + The Shadows give chase when you look at their face.

</details>

<details close>
  <summary>12/28/2019 Version 1.3</summary>
  
  + The Shadows give chase when you look at their face.
  + Included Mixin's library to inject entity spawn conditions.
  + Fully registered an Abyssal Zombie - a hostile entity from AbyssalCraft - with custom sounds, drops, and spawn egg.

</details>

<details close>
  <summary>12/27/2019 Version 1.2</summary>
  
  + Included CottonMC's LibGui library for GUI handling.
  + Backpack inventory now has a GUI!!!

</details>

<details close>
  <summary>12/26/2019 Version 1.1</summary>

  + Fully registered an Abyssal Zombie - a hostile entity from AbyssalCraft - with custom sounds, drops, and spawn egg.
  + Included CottonMC's LibGui library for GUI handling.
  + Backpack inventory now has a GUI!!!
  + Refactored code for server and client-side mod intializations.
  + Backpack is now multi-directional; the block faces in different directions. Backpack is also brown.
  + Added backpack inventory (no GUI); blocks that interact with storage can push items to and from the backpack.

</details>

<details close>
  <summary>12/24/2019 Version 1.0</summary>

  + Added backpack inventory (no GUI); blocks that interact with storage can push items to and from the backpack.
  + Refactored code into separate responsible packages to be initialized by main.
  + Registered/rendered the backpack as a non-functional, but craftable block. It's a blue backpack!
  + Initial Fabric mod environment setup.

</details>
