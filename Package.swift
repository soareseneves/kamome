// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "kamome",
    defaultLocalization: "en",
    platforms: [
        .iOS("9.0")
    ],
    products: [
        .library(name: "kamome", targets: ["kamome"])
    ],
    targets: [
        .target(
            name: "kamome",
            path: "SwiftyKamome",
            exclude: [
                "Info.plist",
            ],
            resources: [.process("Resources")]
        )
    ]
)
