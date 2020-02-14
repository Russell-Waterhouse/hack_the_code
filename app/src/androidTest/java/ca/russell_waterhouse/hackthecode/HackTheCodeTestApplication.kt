package ca.russell_waterhouse.hackthecode

import ca.russell_waterhouse.hackthecode.dependency_injection.ContextModule
import ca.russell_waterhouse.hackthecode.test_dependency_injection.DaggerTestApplicationComponent

class HackTheCodeTestApplication: HackTheCodeApplication() {
    override val appComponent = DaggerTestApplicationComponent.builder().contextModule(ContextModule(this)).build()
}