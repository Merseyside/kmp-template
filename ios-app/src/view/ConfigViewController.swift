import Foundation
import UIKit
import MultiPlatformLibrary
import MultiPlatformLibraryMvvm
import SkyFloatingLabelTextField
import Alamofire

class ConfigViewController: UIViewController {
    @IBOutlet private var tokenField: SkyFloatingLabelTextField!
    @IBOutlet private var languageField: SkyFloatingLabelTextField!
    
    private var viewModel: ListViewModel<News>!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        viewModel = AppComponent.factory.configFactory.createConfigViewModel(eventsDispatcher: EventsDispatcher(listener: self))

        // binding methods from https://github.com/icerockdev/moko-mvvm
        tokenField.bindTextTwoWay(liveData: viewModel.apiTokenField.data)
        tokenField.bindError(liveData: viewModel.apiTokenField.error)
        
        languageField.bindTextTwoWay(liveData: viewModel.languageField.data)
        languageField.bindError(liveData: viewModel.languageField.error)
    }
    
    @IBAction func onSubmitPressed() {
        viewModel.onSubmitPressed()
    }
    
    deinit {
        // clean viewmodel to stop all coroutines immediately
        viewModel.onCleared()
    }
}

extension ConfigViewController: ConfigViewModelEventsListener {
    // callsed from ViewModel by EventsDispatcher - see https://github.com/icerockdev/moko-mvvm
    func routeToNews() {
        performSegue(withIdentifier: "routeToNews", sender: nil)
    }
}
