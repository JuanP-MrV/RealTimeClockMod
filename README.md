## ⏳ Real Time Clock Mod (Minecraft 1.21.1 - NeoForge)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)  
Developed by **JuanP - MrV** | [GitHub Repository](https://github.com/JuanP-MrV/RealTimeClockMod)

### 📌 Overview
**Real Time Clock Mod** is a lightweight, high-performance mod for **NeoForge 1.21.1**. It seamlessly renders your real-world system time as a customizable HUD overlay, allowing you to stay focused on your adventure while keeping track of time.

### 🕰️ Features
- 📟 **Real-Time Synchronization:** Displays your system clock (HH:mm) directly in-game.
- 🎨 **Fully Customizable:** Position the clock anywhere on your screen.
- 🖥️ **Intuitive Preview Mode:** Use an interactive UI to drag and drop your clock.
- 🎮 **Universal Controls:** Reposition using `AWSD` or arrow keys.
- 🚀 **Modern Architecture:** Completely rewritten for NeoForge using `GuiGraphics` and `LayeredDraw` for maximum compatibility.

---

## 🔧 Installation
### Requirements:
- **Minecraft:** `1.21.1`
- **Mod Loader:** [NeoForge](https://neoforged.net/) (Latest version recommended)
- **Java:** `21`

### Steps:
1. **Download** the NeoForge version of the mod from [Releases](https://github.com/JuanP-MrV/RealTimeClockMod/releases).
2. **Place the .jar file** in your Minecraft `mods/` folder.
3. **Launch Minecraft** using the NeoForge profile.

---

## 🎮 Usage Guide
| Action | Key / Control |
| :--- | :--- |
| **Enter Preview Mode** | Press `P` |
| **Move Clock** | `AWSD` or `Arrow Keys` (5px increments) |
| **Save & Exit** | Press `P` or `Enter` |
| **Cancel Changes** | Press `Esc` |

*The position is automatically saved to the configuration file.*

---

## ⚙️ Configuration
The mod uses the **NeoForge Config System** (`ModConfigSpec`). You can find the settings in:
`.minecraft/config/realtimeclockmod-client.toml`

---

## 🛠️ Technical Details (For Developers)
- **Engine:** Migrated to NeoForge 1.21.1.
- **Language:** Java 21.
- **Rendering:** Migrated from `IGuiOverlay` to `LayeredDraw.Layer`.
- **Graphics:** Uses `GuiGraphics` for modern buffer management.

---

## 📜 License
This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.

🔹 **Developer:** _JuanP - MrV_  
🔹 **Version:** `1.1.0` (NeoForge 1.21.1)
