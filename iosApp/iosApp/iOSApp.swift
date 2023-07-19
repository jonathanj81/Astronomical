import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        CommonKt.doInitKoin(databaseDriverFactory: DatabaseDriverFactory())
    }

	var body: some Scene {
		WindowGroup {
            ZStack {
                Color.white.ignoresSafeArea(.all) // status bar color
                ContentView()
            }.preferredColorScheme(.light)
        }
	}
}