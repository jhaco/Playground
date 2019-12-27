# Playground

###### A 1.15.1 Fabric ModLoader port of features and items from older Minecraft mods.
###### The Playground is my personal [Fabric](https://fabricmc.net/) mod learning & development testing ground for Minecraft version 1.15.1. I will be using a pre-existing [project](https://github.com/fabric-community/the-hallow) by The Fabric Community as a template for organizing the project's components.

#### Progress:

|Mod|Progress|Task Update|
|---|--------|------|
|[Wearable Backpacks](https://www.curseforge.com/minecraft/mc-mods/wearable-backpacks)|50%|Added CottonMC's LibGui library. The backpack is now a fully functional storage block complete with an inventory GUI. Now to figure out how to make it portable.|

#### Setup:
* Install a preferred IDE and a Java Development Kit (JDK) for Java 8 or Java 11: https://adoptopenjdk.net/.
* Fabric mod development environment setup instructions can be found here: https://fabricmc.net/wiki/tutorial:setup.
###### Personal note: the onsite tutorials are helpful but also outdated and scuffed. I might consider writing my own guide and posting on Github Pages to document my journey. I also need to stop being lazy and push changed files one-by-one to keep track of individual changes.

---

Version 1.2: `12/27/2019`
> Included CottonMC's LibGui library for GUI handling.
> Backpack inventory now has a GUI!!!

Version 1.1: `12/26/2019`
> Refactored code for server and client-side mod intializations. \
> Backpack is now multi-directional; the block faces in different directions. Backpack is also brown. \
> Added backpack inventory (no GUI); blocks that interact with storage can push items to and from the backpack.

Version 1.0: `12/24/2019`
> Refactored code into separate responsible packages to be initialized by main. \
> Registered/rendered the backpack as a non-functional, but craftable block. It's a blue backpack! \
> Initial Fabric mod environment setup.
